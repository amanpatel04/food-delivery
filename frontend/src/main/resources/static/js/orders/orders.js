
function goPage(pageNumber) {
    const currentUrl = new URL(window.location);
    
    const serverPage = pageNumber;
    
    const rowsPerPage = document.getElementById('rows-select').value || 5;
    
    currentUrl.searchParams.set('page', serverPage);
    currentUrl.searchParams.set('size', rowsPerPage);
    
    window.location.href = currentUrl.toString();
}


document.addEventListener('DOMContentLoaded', function() {
    const rowsSelect = document.getElementById('rows-select');
    if (rowsSelect) {
        rowsSelect.addEventListener('change', function() {
            goPage(0);
        });
    }
});