let imageArray = ["images/dr_stone_poster.jpg", "images/fmab_poster.jpg", "images/one_piece_poster.jpg"];

// Get the image element
let image = document.createElement("img");
image.setAttribute("src", imageArray[0]);
image.setAttribute("id", "image");
// Set the initial image
document.body.appendChild(image);
let index = 0;


// Add event listeners to the buttons
document.getElementById('next').addEventListener('click', nextImage);
document.getElementById('previous').addEventListener('click', previousImage);

function nextImage() {

    let currentImageSrc = image.src;

    // Increment the index to get the next image
    index++;

    // Check if we have reached the end of the array
    if (index >= imageArray.length) {
        index = 0; // Wrap around to the first image
    }

    // Update the src attribute with the new image path
    image.src = imageArray[index];
    
}

function previousImage() {
    let currentImageSrc = image.src;

    // Decrement the index to get the previous image
    index--;

    // Check if we have reached the beginning of the array
    if (index < 0) {
        index = imageArray.length - 1; // Wrap around to the last image
    }

    // Update the src attribute with the new image path
    image.src = imageArray[index];
}
