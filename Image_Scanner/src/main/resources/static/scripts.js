document.getElementById('imageUploadForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const fileInput = document.getElementById('file');
    const file = fileInput.files[0];

    if (!file) {
        alert("Please select an image file.");
        return;
    }

    // Create a FormData object to hold the file
    const formData = new FormData();
    formData.append('file', file);

    // Show loading text
    document.getElementById('loading').style.display = 'block';
    document.getElementById('output').style.display = 'none';
    document.getElementById('error').style.display = 'none';

    // Send the file to the backend via fetch
    fetch('http://localhost:8080/api/upload', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to upload');
        }
        return response.text();
    })
    .then(extractedText => {
        // Hide loading text
        document.getElementById('loading').style.display = 'none';
        
        // Show the extracted text
        document.getElementById('extractedText').textContent = extractedText;
        document.getElementById('output').style.display = 'block';
    })
    .catch(error => {
        // Hide loading text and show error
        document.getElementById('loading').style.display = 'none';
        document.getElementById('error').style.display = 'block';
        console.error("Error:", error);
    });
});
