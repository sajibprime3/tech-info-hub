@import gg.jte.Content

@param Content header
@param Content main

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/css/style.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="/webjars/htmx.org/2.0.4/dist/htmx.js"></script>
</head>
<body>


<div class="header bg-white">
    ${header}
</div>

<div class="main overflow-y-scroll flex flex-row">
    ${main}
</div>

</body>
</html>