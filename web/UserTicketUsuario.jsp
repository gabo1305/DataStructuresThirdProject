<html>

<title>User Tickets</title>

<head>
    <link rel="stylesheet" href="tableStyle.css">
</head>

<script>
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const product = urlParams.get('UserName')
    const Http = new XMLHttpRequest();
    var ticketText;
    var yaEsta=false;

    function all() {
        getTickets()
    }

    function getTickets() {
        Http.open("GET",'http://localhost:9080/ConsultFromUser?UserName='+product);
        Http.send();
        Http.onreadystatechange = (e) => {
            if (!yaEsta) {
                ticketText = Http.responseText;
                tickets()
                yaEsta=true;
            }
        };
    }

    function tickets() {
        obj = JSON.parse(ticketText)
        var tableRow = "<tr><th>Ticket Id</th><th>Date</th><th>Trajectory</th></tr>"

        for (var i=0; i<obj.length;i++){
            tableRow += "<tr><td>"+obj[i].ID+"</td><td>"+obj[i].date+"</td><td>"+obj[i].trajectory+"</td></tr>";
        }
        document.getElementById('userTicketsTable').innerHTML += tableRow;
    }

</script>

<body onload="all()">

<table id="userTicketsTable">
</table>

</body>

</html>