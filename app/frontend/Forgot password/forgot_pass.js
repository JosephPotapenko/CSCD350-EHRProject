document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('.login-box');

    form.addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent default form submission

        const position = document.getElementById('position').value;
        const email = document.getElementById('email').value;

        try {
            const response = await fetch('users.json'); // Fetch the JSON file
            const users = await response.json();

            // Check if the user exists in the JSON database
            const user = users.find(user => user.position === position && user.email === email);

            if (user) {
                alert("Please check your email for your password.");
                // Code to send an email to the user could go here if possible
            } else {
                alert("User not found. Please Register.");
            }
        } catch (error) {
            alert('Please check your email for further instructions');
        }
    });
});
