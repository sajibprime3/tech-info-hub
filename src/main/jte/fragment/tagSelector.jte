@import com.dark.techinfo.tag.dto.TagDto
@import java.util.List

@param List<TagDto> tagDtoList


<div class="bg-white p-6 rounded-lg w-full max-w-md">
    <h3 class="text-xl font-bold mb-2">Select Tags</h3>
    
    <!-- TODO Implement Searching system for tags.
    <input type="text" id="searchTags" oninput="filterTags()" placeholder="Search tags..."
           class="w-full p-2 border border-gray-300 rounded-lg mb-2">
           -->

    <div id="tagList" class="max-h-40 overflow-y-auto space-y-2">
        <!-- Dynamically generated tag checkboxes -->
        @for(TagDto tag: tagDtoList)
            @template.fragment.selectableTagItem(tag = tag)
        @endfor
        
    </div>

    <div class="flex justify-end gap-2 mt-3">
        <button onclick="hide('#tagSelectorPopup', 'flex', 'hidden')" class="bg-gray-500 text-white px-4 py-2 rounded-lg mr-2">Cancel</button>
        <div class="flex basis-full bg-blue-600 text-white px-4 py-2 rounded-lg justify-center self-center"
             onclick="show('#tagFormPopup', 'flex', 'hidden');"
             hx-get="/tag/form"
             hx-trigger="click"
             hx-target="#tagFormPopup"
             hx-swap="innerHTML">
            <svg xmlns="http://www.w3.org/2000/svg" width="2rem" height="2rem" viewBox="0 0 15 15"><path fill="currentColor" d="M8 2.5a.5.5 0 0 0-1 0V7H2.5a.5.5 0 0 0 0 1H7v4.5a.5.5 0 0 0 1 0V8h4.5a.5.5 0 0 0 0-1H8V2.5Z"/></svg>
        </div>
        <button onclick="saveTags()" class="bg-blue-600 text-white px-4 py-2 rounded-lg">Save</button>
    </div>
</div>
<!-- Overlay -->
<div class="fixed -z-10 inset-0 bg-black backdrop-blur-sm backdrop-filter bg-opacity-40" onclick="hide('#tagSelectorPopup', 'flex', 'hidden');"></div>
<div class="fixed inset-0 justify-center items-center hidden" id="tagFormPopup"></div>

