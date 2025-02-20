@import com.dark.techinfo.technology.dto.TechnologyDto

@param TechnologyDto technologyDto


<div class="flex items-center">
    <input type="checkbox" onchange="toggleCheck(this);" id="tag-${technologyDto.getId()}" value="${technologyDto.getId()}" class="mr-2">
    <label for="tag-${technologyDto.getId()}">${technologyDto.getName()}</label>
</div>