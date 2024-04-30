<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form action="$/hello" method="GET">
    <label for="year">Year:</label>
    <input type="text" id="year" name="year"><br><br>
    <label for="month">Month:</label>
    <input type="text" id="month" name="month"><br><br>
    <label for="salary">Salary:</label>
    <input type="text" id="salary" name="salary"><br><br>
    <input type="submit" value="Submit">
</form>
<div id="result"></div>
<script>
    $(document).ready(function () {
        $('#calculatorForm').submit(function (event) {
            event.preventDefault(); // Prevent default form submission

            // Get form data
            var formData = {
                year: $('#year').val(),
                month: $('#month').val(),
                salary: $('#salary').val()
            };

            // Send AJAX GET request to server
            $.ajax({
                type: 'GET',
                url: '/hello',
                data: formData,
                dataType: 'html', // Expect HTML response
                success: function (response) {
                    // Replace content of 'result' div with HTML response
                    $('#result').html(response);
                },
                error: function (xhr, status, error) {
                    // Handle error
                    $('#result').text('Error: ' + error);
                }
            });
        });
    });
</script>
</body>
</html>