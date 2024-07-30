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
                const role = await response.text();
                alert('Login successful'); // Display success message

                // Redirect based on role
                if (role === 'doctor' || role === 'Doctor' || role === 'nurse' || role === 'Nurse') {
                    window.location.href = '/employeedashboard';
                } else if (role === 'patient' || role === 'Patient') {
                    window.location.href = '/patientdashboard';
                } else {
                    alert('Unknown role');
                }
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
