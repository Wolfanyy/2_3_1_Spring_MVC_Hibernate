let editButtons = document.querySelectorAll('.button-edit');

editButtons.forEach(button => {

    button.addEventListener('click', function () {
        const row = button.closest('tr');
        const fields = row.querySelectorAll('.user-field');

        if (button.textContent === 'Edit') {
            fields.forEach(field => {
                field.disabled = false;
            })
            button.textContent = "Save";
        } else {
            button.type = 'submit';
        }
    });
});