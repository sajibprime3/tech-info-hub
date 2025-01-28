@import com.dark.techinfo.company.Company
@import com.dark.techinfo.technology.Technology
@import com.dark.techinfo.tag.Tag
@import java.util.List

@param List<Company> companyList

@for(Company company: companyList)
    <div class="card w-full bg-white rounded-lg shadow-md">
        <div class="info p-4 flex flex-col items-start justify-between">
            <div>
                <h2 class="text-xl font-semibold text-gray-800">${company.getName()}</h2>
                <p class="text-gray-600 mt-2">Leading provider of innovative cloud solutions.</p>
                <p>${company.getLocation()}</p>
            </div>
        </div>
        <div class="tech mt-4">
            <div class="relative group">
                <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java"
                     class="w-6 h-6">
                <span
                        class="absolute left-1/2 transform -translate-x-1/2 translate-y-2 opacity-0 group-hover:opacity-100 text-xs bg-gray-800 text-white px-2 py-1 rounded-lg">Java</span>
            </div>
            <div class="relative group ml-4">
                <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" alt="Docker"
                     class="w-6 h-6">
                <span
                        class="absolute left-1/2 transform -translate-x-1/2 translate-y-2 opacity-0 group-hover:opacity-100 text-xs bg-gray-800 text-white px-2 py-1 rounded-lg">Docker</span>
            </div>
        </div>

        <div class="tag p-4">
            <div class="mt-4">
                <h3 class="text-sm font-medium text-gray-800">Tags:</h3>
                <div class="flex flex-wrap gap-2 mt-2">
                    @for(Technology technology: company.getTechnologies())
                        @for(Tag tag: technology.getTags())
                            <span class="px-3 py-1 text-sm text-gray-800 bg-purple-100 bg-opacity-50 rounded">#${tag.getName()}</span>
                        @endfor
                    @endfor
                    
                </div>
            </div>
        </div>
    </div>
@endfor
