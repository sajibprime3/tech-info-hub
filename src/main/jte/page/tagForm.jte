
<div class="bg-white shadow-lg rounded-xl p-6 w-full max-w-md">
    <h2 class="text-2xl font-bold text-gray-800 mb-4">Create a New Tag</h2>

    <form id="tagForm" class="space-y-4">
        <!-- Name Field -->
        <div>
            <label for="tagname" class="block text-sm font-medium text-gray-700">Tag Name</label>
            <input type="text" id="tagname" name="name"
                   class="mt-1 p-3 w-full border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 outline-none"
                   placeholder="Enter tag name." required>
        </div>
        <!-- Submit Button -->
        <button type="submit"
                class="w-full bg-blue-600 text-white py-3 rounded-lg text-lg font-medium hover:bg-blue-700 transition duration-300">
            Create Tag
        </button>
    </form>
    <div id="formResponse" class="mt-4 text-center text-sm text-gray-600"></div>
</div>
<!-- Overlay -->
<div class="fixed -z-10 inset-0 bg-black backdrop-blur-sm backdrop-filter bg-opacity-40" onclick="hide('#tagFormPopup', 'flex', 'hidden');"></div>


<script>
    
    document.getElementById('tagForm').addEventListener('submit', async function (event) {
        event.preventDefault();
        let tagname = document.getElementById('tagname').value.trim();
        if (!tagname) {
            alert("Tag name and at least one tag are required!");
            return;
        }
        var data = new Object();
        data.name = tagname;
        
        let response = await fetch('/api/v1/tag', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        
        if (response.ok) {
            alert("Tag created successfully!");
            document.getElementById('tagForm').reset();
        } else {
            alert("Failed to create Tag.");
        }
    });
</script>
