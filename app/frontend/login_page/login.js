document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('.login-box');

    form.addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent default form submission

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
            /*
            if (response.ok) {
                const role = await response.text();
                alert('Login successful'); // Display success message

                // Store the user role in local storage
                localStorage.setItem('userRole', role);


            /*if (response.ok) {
                // Assuming the response is JSON with properties 'role' and 'user_id'
                const data = await response.json(); // Get the response as JSON

                const role = data.role; // Extract the user role
                const user_id = data.user_id; // Extract the user ID

                alert('Login successful'); // Display success message

                // Store the user role and ID in local storage
                localStorage.setItem('userRole', role);
                localStorage.setItem('userId', user_id);
*/
            if (response.ok) {
                // Get the response as JSON
                const data = await response.json();

                // Extract role and user ID from the JSON response
                const role = data.role;
                const user_id = data.userId; // Note: Ensure 'userId' matches the key from your server response

                alert('Login successful'); // Display success message

                // Store the user role and ID in local storage
                localStorage.setItem('userRole', role);
                localStorage.setItem('userId', user_id);

                // Redirect based on role
                if (role === 'doctor' || role === 'Doctor') {
                    window.location.href = 'http://localhost:63342/cs350-summer2024-project-dev-oops/app/frontend/doctor_home_page/doctorhomepage.html';
                } else if(role === 'nurse' || role === 'Nurse')  {
                    window.location.href = 'http://localhost:63342/cs350-summer2024-project-dev-oops/app/frontend/nurse_home_page/nursehomepage.html';
                } else if (role === 'patient' || role === 'Patient') {
                    window.location.href = 'http://localhost:63342/cs350-summer2024-project-dev-oops/app/frontend/patient_home_page/patienthomepage.html';
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
