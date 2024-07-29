document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('.login-box');

    form.addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent default form submission

        const position = document.getElementById('position').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        try {
            const response = await fetch('http://localhost:8080/auth/login', { // Update this URL as needed
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams({
                    email: email,
                    password: password
                })
            });

            if (response.ok) {
                const message = await response.text();
                alert(message); // Display success message
                window.location.href = '/dashboard'; // Redirect after successful login
            } else {
                const error = await response.text();
                alert(error); // Display error message
            }
        } catch (error) {
            console.error('Error:', error);
            alert('An error occurred. Please try again.');
        }
    });
});
