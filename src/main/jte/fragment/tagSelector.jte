@import com.dark.techinfo.tag.dto.TagDto
@import java.util.List

@param List<TagDto> tagDtoList


<!-- Tag Selection Popup -->

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

        <div class="flex justify-end mt-3">
            <button onclick="hide('#tagPopup', 'flex', 'hidden')" class="bg-gray-500 text-white px-4 py-2 rounded-lg mr-2">Cancel</button>
            <button onclick="saveTags()" class="bg-blue-600 text-white px-4 py-2 rounded-lg">Save</button>
        </div>
    </div>

