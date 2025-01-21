
@template.layout.standard(header = @`
    <div class="text-3xl text-center font-bold text-red-100">
        Info tech hub
    </div>
    
    <div class="w-full p-2 shadow-xl rounded-2xl ">
        <div class="relative flex items-center ">
            <!-- this is pure tailwind -->
            <input type="text" id="search" name="search"
                   class="w-full p-2 font-sans text-lg font-semibold text-center border border-gray-200 text-red-950 rounded-xl focus:border-gray-400 focus:outline-none peer"
                   placeholder=" "
            >
            <label for="search"
                   class="absolute font-mono font-bold text-gray-400 duration-100 -translate-x-1/2 -translate-y-1/2 bg-white opacity-0 top-1/2 left-2/4 peer-placeholder-shown:opacity-100 peer-placeholder-shown:text-gray-400 peer-placeholder-shown:left-1/2">Search</label>


        </div>
    </div>
`,
main = @`
    
    
    
`)
