@import com.dark.techinfo.tag.dto.TagDto

@param TagDto tag


<div class="flex items-center">
    <input type="checkbox" onchange="toggleCheck(this, selectedTags);" id="tag-${tag.getId()}" value="${tag.getId()}" class="mr-2">
    <label for="tag-${tag.getId()}">${tag.getName()}</label>
</div>