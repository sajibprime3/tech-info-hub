
@template.layout.standard(header = @`
    <div class="header bg-white flex flex-row p-5 gap-2">
        <div class="text-4xl text-center font-bold flex flex-row gap-1">
            <img src="/images/techInfoLogo.png" alt="techInfo" width="50px" height="50px">
            <span class="self-center font-serif">
                Info tech hub
            </span>
        </div>
        
        <div class="p-2 rounded-2xl ">
            <div class="relative flex items-center ">
                <input type="text" id="search" name="s"
                       class="w-full p-2 font-sans text-lg font-semibold text-center border border-gray-200 text-red-950 rounded-xl focus:border-gray-400 focus:outline-none peer" 
                       placeholder=" "
                       hx-get="/company/search"
                       hx-trigger="keyup changed delay:500,load once"
                       hx-target="#result"
                       hx-swap="innerHTML"
                >
                <label for="search"
                       class="absolute font-mono font-bold text-gray-400 duration-100 -translate-x-1/2 -translate-y-1/2 bg-white opacity-0 top-1/2 left-2/4 peer-placeholder-shown:opacity-100 peer-placeholder-shown:text-gray-400 peer-placeholder-shown:left-1/2">Search</label>
            </div>
        </div>

        <div class="ml-auto flex flex-row gap-1">
            <div class="flex justify-center self-center rounded-full bg-blue-700 text-white"
                 onclick="show('#companyFormPopup', 'flex', 'hidden');" 
                 hx-get="/company/form" 
                 hx-trigger="click" 
                 hx-target="#companyFormPopup" 
                 hx-swap="innerHTML">
                
                <svg xmlns="http://www.w3.org/2000/svg" width="2rem" height="2rem" viewBox="0 0 15 15"><path fill="currentColor" d="M8 2.5a.5.5 0 0 0-1 0V7H2.5a.5.5 0 0 0 0 1H7v4.5a.5.5 0 0 0 1 0V8h4.5a.5.5 0 0 0 0-1H8V2.5Z"/></svg>
            </div>
            <!-- TODO Add menu.
            <div class="bg-zinc-400 justify-center self-center rounded-full text-white">
                <svg xmlns="http://www.w3.org/2000/svg" width="2rem" height="2rem" viewBox="-150 -150 1300 1300"><path fill="currentColor" d="M160 448a32 32 0 0 1-32-32V160.064a32 32 0 0 1 32-32h256a32 32 0 0 1 32 32V416a32 32 0 0 1-32 32H160zm448 0a32 32 0 0 1-32-32V160.064a32 32 0 0 1 32-32h255.936a32 32 0 0 1 32 32V416a32 32 0 0 1-32 32H608zM160 896a32 32 0 0 1-32-32V608a32 32 0 0 1 32-32h256a32 32 0 0 1 32 32v256a32 32 0 0 1-32 32H160zm448 0a32 32 0 0 1-32-32V608a32 32 0 0 1 32-32h255.936a32 32 0 0 1 32 32v256a32 32 0 0 1-32 32H608z"/></svg>
            </div>
            -->
        </div>
        
        
    </div>
    
`,
main = @`
    
    <div class="w-full flex flex-col gap-1" id="result"></div>
    <div class="fixed inset-0 justify-center items-center hidden" id="companyFormPopup" ></div>
    
`)
