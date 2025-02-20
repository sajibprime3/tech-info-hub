@import com.dark.techinfo.technology.dto.TechnologyDto
@import java.util.List

@param List<TechnologyDto> technologyDtoList


<!-- Technology Selection Popup -->

<div class="bg-white p-6 rounded-lg w-full max-w-md">
    <h3 class="text-xl font-bold mb-2">Select Technologies</h3>

    <!-- TODO Implement Searching system for technologies.
    <input type="text" id="searchTechnologies" placeholder="Search technologies..."
           class="w-full p-2 border border-gray-300 rounded-lg mb-2">
           -->

    <div id="technologyList" class="max-h-40 overflow-y-auto space-y-2">
        <!-- Dynamically generated technology checkboxes -->
        @for(TechnologyDto technology: technologyDtoList)
            @template.fragment.selectableTechnologyItem(technologyDto = technology)
        @endfor

    </div>

    <div class="flex justify-end mt-3">
        <button onclick="hide('#technologyPopup', 'flex', 'hidden')" class="bg-gray-500 text-white px-4 py-2 rounded-lg mr-2">Cancel</button>
        <button onclick="saveTechnologies()" class="bg-blue-600 text-white px-4 py-2 rounded-lg">Save</button>
    </div>
</div>