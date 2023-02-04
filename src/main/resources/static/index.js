$(document).ready(function() {
    let result = $("publishResult").text();
    if (result == 'success') {
        console.log('Event was published...');
        alert('Event Published! Publish another one...');
    } else if (result == 'failure') {
        console.log('Event publishing failed...');
        alert('Something went wrong! Please try again...');
    }
});

function resetForm() {
    document.getElementById("payload-input").value = '';
    document.getElementById("topic-name").value = '';
}