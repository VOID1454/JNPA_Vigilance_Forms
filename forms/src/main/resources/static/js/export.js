$(document).ready(function () {
    // Initialize DataTables for all tables
    $('#Expenditure').DataTable();
    $('#ProgressOfWork').DataTable();
    $('#ProgressOfWorkCivil').DataTable();
    $('#ForeignVisits').DataTable();
    $('#SuspensionReport').DataTable();
    $('#PenaltyCase').DataTable();
    $('#Form5A').DataTable();
    $('#Form5B').DataTable();
    $('#Form5C').DataTable();
    $('#Contract').DataTable();

    // Hide all tables initially
    $('.table-container').hide();

    // Function to show a specific table
    window.showTable = function (tableId) {
        $('.table-container').hide(); // Hide all tables
        $(`#${tableId}`).closest('.table-container').show(); // Show the selected table
    };

    // Function to show all tables
    window.showAllTables = function () {
        $('.table-container').show();
    };
});