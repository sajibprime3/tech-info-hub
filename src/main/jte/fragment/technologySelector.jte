@import com.dark.techinfo.technology.dto.TechnologyDto
@import java.util.List

@param List<TechnologyDto> technologyDtoList


<!-- Technology Selection Popup -->

<div class="bg-white p-6 rounded-lg w-full max-w-md">
    <div class="flex flex-row">
        <h3 class="text-xl font-bold mb-2">Select Technologies</h3>
        <div class="ml-auto flex flex-row gap-1">
            
        </div>
    </div>
    

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

    <div class="flex justify-between mt-3 gap-2">
        <button onclick="hide('#technologySelectorPopup', 'flex', 'hidden')" class="bg-gray-500 text-white px-4 py-2 rounded-lg">Cancel</button>
        <div class="flex basis-full bg-blue-600 text-white px-4 py-2 rounded-lg justify-center self-center"
             onclick="show('#technologyFormPopup', 'flex', 'hidden');"
             hx-get="/technology/form"
             hx-trigger="click"
             hx-target="#technologyFormPopup"
             hx-swap="innerHTML">
            <svg xmlns="http://www.w3.org/2000/svg" width="2rem" height="2rem" viewBox="0 0 15 15"><path fill="currentColor" d="M8 2.5a.5.5 0 0 0-1 0V7H2.5a.5.5 0 0 0 0 1H7v4.5a.5.5 0 0 0 1 0V8h4.5a.5.5 0 0 0 0-1H8V2.5Z"/></svg>
        </div>
        <button onclick="saveTechnologies();" class="bg-blue-600 text-white px-4 py-2 rounded-lg">Save</button>
    </div>
</div>
<!-- Overlay -->
<div class="fixed -z-10 inset-0 bg-black backdrop-blur-sm backdrop-filter bg-opacity-40" onclick="hide('#technologySelectorPopup', 'flex', 'hidden');"></div>
<div class="fixed inset-0 justify-center items-center hidden" id="technologyFormPopup"></div>