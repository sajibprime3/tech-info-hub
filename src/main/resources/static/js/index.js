function show(target, showClass, hideClass) {
    const nodes = document.querySelectorAll(target);
    nodes.forEach(node => {
        node.classList.remove(hideClass);
        node.classList.add(showClass);
    });
}

function hide(target, showClass, hideClass) {
    const nodes = document.querySelectorAll(target);
    nodes.forEach(node => {
        node.classList.remove(showClass);
        node.classList.add(hideClass);
    }); 
}

function toggleCheck(checkbox, selectedMap) {
    
    if (checkbox.checked) {
        selectedMap.set(parseInt(checkbox.value), checkbox.nextElementSibling.textContent);
    } else {
        selectedMap.delete(parseInt(checkbox.value));
    }
}
