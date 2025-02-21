

<div class="bg-white shadow-lg rounded-xl p-6 w-full max-w-md">
    <h2 class="text-2xl font-bold text-gray-800 mb-4">Create a New Company</h2>

    <form id="companyForm" class="space-y-4">
        <!-- Name Field -->
        <div>
            <label for="companyName" class="block text-sm font-medium text-gray-700">Company Name</label>
            <input type="text" id="companyName" name="name"
                   class="mt-1 p-3 w-full border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none"
                   placeholder="Enter company name" required>
        </div>
        
        <div>
            <label for="location" class="block text-sm font-medium text-gray-700">Location</label>
            <input type="text" id="location" name="location"
                   class="mt-1 p-3 w-full border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none"
                   placeholder="https://logos-world.net/... " required>
        </div>
        
        
        <!-- Technology Selector -->
        <div>
            <label class="block text-sm font-medium text-gray-700">Technologies</label>
            <div id="selectedTechnologies" class="mt-1 flex flex-wrap gap-2 p-2 border border-gray-300 rounded-lg cursor-pointer bg-gray-50"
                 onclick="show('#technologySelectorPopup', 'flex', 'hidden');"
                 hx-get="/technology/selector"
                 hx-trigger="click once"
                 hx-target="#technologySelectorPopup"
                 hx-swap="innerHTML">
                Select Technologies...
            </div>
        </div>

        <!-- Submit Button -->
        <button type="submit"
                class="w-full bg-blue-600 text-white py-3 rounded-lg text-lg font-medium hover:bg-blue-700 transition duration-300">
            Create Company
        </button>
    </form>
    <div id="formResponse" class="mt-4 text-center text-sm text-gray-600"></div>
</div>
<!-- Overlay -->
<div class="fixed -z-10 inset-0 bg-black backdrop-blur-sm backdrop-filter bg-opacity-40" onclick="hide('#companyFormPopup', 'flex', 'hidden');"></div>

<!-- Tag Selection Popup -->
<div id="technologySelectorPopup" class="hidden fixed inset-0 flex justify-center items-center"></div>

<script>
    let selectedTechnologies = new Map();
    
    function saveTechnologies() {
        let technologyDisplay = document.getElementById("selectedTechnologies");
        technologyDisplay.innerHTML = "";
        selectedTechnologies.forEach((name, id) => {
            technologyDisplay.innerHTML += '<span class="px-1 py-1 bg-blue-100 text-blue-800 rounded-lg text-xs">#'+ name +'</span>';
        });
        if (selectedTechnologies.size==0) {
            document.getElementById("selectedTechnologies").innerHTML = "Select Technologies..."
        }
        hide('#technologySelectorPopup', 'flex', 'hidden');
    }
    
    
    
    document.getElementById('companyForm').addEventListener('submit', async function (event) {
        event.preventDefault();

        let companyName = document.getElementById('companyName').value.trim();
        let location = document.getElementById('location').value;
        let technologyIds = Array.from(selectedTechnologies.keys());

        if (!companyName || technologyIds.length === 0) {
            alert("Company name and at least one tag are required!");
            return;
        }
        
        var data = new Object();
        data.name = companyName;
        data.location = location;
        data.technologies = technologyIds;
        
        let response = await fetch('/api/v1/company', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        
        if (response.ok) {
            alert("Company created successfully!");
            document.getElementById('companyForm').reset();
            selectedTechnologies.clear();
            document.getElementById('selectedTechnologies').innerHTML = "Select Technologies...";
        } else {
            alert("Failed to create company.");
        }
    });


</script>
