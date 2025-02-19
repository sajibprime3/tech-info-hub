


@template.layout.standard(header = @`
    
`,
    
    
main = @`
    <div class="bg-white shadow-lg rounded-xl p-6 w-full max-w-md">
        <h2 class="text-2xl font-bold text-gray-800 mb-4">Create a New Technology</h2>
        
        <form id="techForm" class="space-y-4">
            <!-- Name Field -->
            <div>
                <label for="techName" class="block text-sm font-medium text-gray-700">Technology Name</label>
                <input type="text" id="techName" name="name"
                       class="mt-1 p-3 w-full border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none"
                       placeholder="Enter technology name" required>
            </div>
            
            
            <!-- Image Upload -->
            <!-- TODO Implement Image Uploading Mechanism instead of Url
            <div>
                <label class="block text-sm font-medium text-gray-700">Upload Image</label>
                <input type="file" id="techImage" name="image" accept="image/*"
                       class="mt-1 w-full border border-gray-300 rounded-lg p-2 cursor-pointer">
            </div>
            -->
            <div>
                <label for="imageUrl" class="block text-sm font-medium text-gray-700">Image</label>
                <input type="text" id="imageUrl" name="imageUrl"
                       class="mt-1 p-3 w-full border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none"
                       placeholder="https://logos-world.net/... " required>
            </div>
            
            

            <!-- Testing -->
            
            
            <!-- Tag Selector -->
            <div>
                <label class="block text-sm font-medium text-gray-700">Tags</label>
                <div id="selectedTags" class="mt-1 flex flex-wrap gap-2 p-2 border border-gray-300 rounded-lg cursor-pointer bg-gray-50"
                     onclick="show('#tagPopup', 'flex', 'hidden');"
                     hx-get="/tag/selector"
                     hx-trigger="click once"
                     hx-target="#tagPopup"
                     hx-swap="innerHTML">
                    Select Tags...
                </div>
            </div>

            <!-- Submit Button -->
            <button type="submit"
                    class="w-full bg-blue-600 text-white py-3 rounded-lg text-lg font-medium hover:bg-blue-700 transition duration-300">
                Create Technology
            </button>
        </form>
        <div id="formResponse" class="mt-4 text-center text-sm text-gray-600"></div>
    </div>

    <!-- Tag Selection Popup -->
    <div id="tagPopup" class="hidden fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center">hi</div>
    
    <script>
        let selectedTags = new Map();
        
        function saveTags() {
            let tagDisplay = document.getElementById("selectedTags");
            tagDisplay.innerHTML = "";
            selectedTags.forEach((name, id) => {
                tagDisplay.innerHTML += '<span class="px-1 py-1 bg-blue-100 text-blue-800 rounded-lg text-xs">#'+ name +'</span>';
            });
            if (selectedTags.size==0) {
                document.getElementById("selectedTags").innerHTML = "Select Tags..."
            }
            hide('#tagPopup', 'flex', 'hidden');
        }
        
        function toggleCheck(checkbox) {
            if (checkbox.checked) {
                selectedTags.set(parseInt(checkbox.value), checkbox.nextElementSibling.textContent);
            } else {
                selectedTags.delete(parseInt(checkbox.value));
            }
            
        }
        
        document.getElementById('techForm').addEventListener('submit', async function (event) {
            event.preventDefault();

            let techName = document.getElementById('techName').value.trim();
            let imageUrl = document.getElementById('imageUrl').value;
            let tagIds = Array.from(selectedTags.keys());

            if (!techName || tagIds.length === 0) {
                alert("Technology name and at least one tag are required!");
                return;
            }
            
            var data = new Object();
            data.name = techName;
            data.imageUrl = imageUrl;
            data.tags = tagIds;
            
            let response = await fetch('/api/v1/technology', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
            
            if (response.ok) {
                alert("Technology created successfully!");
                document.getElementById('techForm').reset();
                selectedTags.clear();
                document.getElementById('selectedTags').innerHTML = "Select Tags...";
            } else {
                alert("Failed to create technology.");
            }
        });
        

    </script>
    
`)