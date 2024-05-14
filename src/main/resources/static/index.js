$(document).ready(function () {
  let result = $("#publishResult").text();
  console.log(`Result: ${result}...`)
  if (result === 'success') {
    console.log('Event was published...');
    alert('Event Published! Publish another one...');
  } else if (result === 'failure') {
    console.log('Event publishing failed...');
    alert('Something went wrong! Please try again...');
  }
});

function formatJson() {
  // Get the JSON data from the textbox
  let jsonInput = document.getElementById('payload-input').value;

  try {
    // Parse the JSON data
    let parsedJson = JSON.parse(jsonInput);

    // Format the JSON data & Set the formatted JSON back to the text-box
    document.getElementById('payload-input').value = JSON.stringify(parsedJson,
        null,
        2);
  } catch (e) {
    // Handle JSON parsing error
    alert('Invalid JSON data. Please check and try again.');
  }
}

function resetForm() {
  document.getElementById("payload-input").value = '';
  document.getElementById("topic-name").value = '';
}