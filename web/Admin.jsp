<html>

<title>Admin</title>

<head>
    <link rel="stylesheet" href="tableStyle.css">
</head>

<script>
    const url='http://localhost:9080/Update';
    const url2='http://localhost:9080/addStopping';
    const url3='http://localhost:9080/deleteNode';
    const url4='http://localhost:9080/newRoute';
    const url5='http://localhost:9080/deleteRoute';
    const urlUsersRoute='http://localhost:9080/usersRoute';
    const urlUserTicketRoute="http://localhost:9080/UserTicketRuta.jsp?Node=";
    const urlConsultDay='http://localhost:9080/consultDate?Date=';


    const Http= new XMLHttpRequest();
    const Http2= new XMLHttpRequest();
    const Http3 = new XMLHttpRequest();
    var Http4 = new XMLHttpRequest();
    var Http5 = new XMLHttpRequest();
    var Http6 = new XMLHttpRequest();
    var Http7 = new XMLHttpRequest();
    const HttpMethod="GET";
    var yaEsta = false;
    var text;
    var usersText;
    var ticketFechaText;
    var Usuario='Usuario';

    function getText() {
        Http.open(HttpMethod, url);
        Http.send();
        Http.onreadystatechange = (e) => {
            text = Http.responseText;
            estaciones()
        };
    }

    function getUsers() {
        Http2.open(HttpMethod,urlUsersRoute)
        Http2.send();
        Http2.onreadystatechange = (e) =>{
            usersText = Http2.responseText;
        }
    }



    function all() {
        yaEsta=false;
        getText()
        getUsers()
    }

    function estaciones() {
        obj = JSON.parse(text);
        var estacionOption = "<option name=''> select</option>"
        var estacionOptionReservacion = "<option name=''> Route</option>"

        for (var i = 0; i<obj.nodes.length;i++){
            estacionOption += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
            estacionOptionReservacion += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
        }
        document.getElementById('dropdownEstacionInicial').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionFinal').innerHTML = estacionOption;
        document.getElementById('dropdownEstaciones').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionEliminar').innerHTML = estacionOption;
        document.getElementById('dropdownReservaciones').innerHTML = estacionOptionReservacion;
    }
    
    function paradasDisponibles() {
        obj = JSON.parse(text);
        var estacionId = document.getElementById("dropdownEstaciones");
        var paradasOption = "<option name=''> select</option>"

        for (var i=0; i<obj.edges.length; i++){
            if (obj.edges[i].source === estacionId.value){
                paradasOption += "<option value='"+obj.nodes[obj.edges[i].target].id+"'>"+obj.nodes[obj.edges[i].target].label+"</option>"
            }
        }
        document.getElementById('dropdownParadas').innerHTML = paradasOption;
    }

    function reservaciones(tipoDeReservacion) {
        if (tipoDeReservacion===Usuario){
            obj = JSON.parse(usersText);
                var tableRow = "<tr><th>User</th><th>Amount of tickets</th></tr>"

            for (var i=0; i<obj.length; i++){
                tableRow += "<tr><td><a href='UserTicketUsuario.jsp?UserName="+obj[i].ID+"'>"+obj[i].ID+"<a></td><td>"+obj[i].wallet.tickets.length+"</td></tr>";
            }
            document.getElementById('userTable').innerHTML = tableRow;
        }
    }

    function porRuta() {
        var e = document.getElementById("dropdownReservaciones");
        var strUser = e.options[e.selectedIndex].value;
        window.location.href=urlUserTicketRoute+strUser;
    }

    function getTicketFecha() {
        var fecha = document.getElementById("fecha")
        Http3.open(HttpMethod,urlConsultDay+fecha.value)
        Http3.send();
        Http3.onreadystatechange=(e)=>{
            ticketFechaText = Http3.responseText;
            obtenerFecha()
        }
    }

    function obtenerFecha() {
        obj = JSON.parse(ticketFechaText);
        var tableRow = "<tr><th>User</th><th>Trajectory</th><th>Ticket Id</th><th>Price</th></tr>"
        for (var i=0; i<obj.length; i++){
            tableRow += "<tr><td>"+obj[i].UserID+"</td><td>"+obj[i].trajectory+"</td><td>"+obj[i].ID+"</td><td>"+obj[i].price+"</td></tr>";
        }
        document.getElementById('userTable').innerHTML = tableRow;
    }

    function agregarEstacion() {

        var StopName = document.getElementById("StopName").value
        var XPos = document.getElementById("XPos").value
        var YPos = document.getElementById("YPos").value

        var get = url2+"?StopName="+StopName+"&XAxis="+XPos+"&YAxis="+YPos;
        if (StopName==""|| XPos==""||YPos==""){
            alert("you have unfinished spaces")
            return;
        }else{
            Http4.open(HttpMethod, get)
            Http4.send()
            Http4.onreadystatechange = (e) => {
                if(Http4.readyState === XMLHttpRequest.DONE) {
                    alert(Http4.responseText)
                }
            }

        }

    }

    function eliminarEstacion() {
        var NodeId = document.getElementById("dropdownEstacionEliminar").value
        var get = url3+"?NodeID="+NodeId;
        Http5.open(HttpMethod, get)
        Http5.send()
        Http5.onreadystatechange = (e) => {
            if(Http5.readyState === XMLHttpRequest.DONE) {
                alert(Http5.responseText)
            }
        }
    }

    function agregarRuta() {
        var Initial = document.getElementById("dropdownEstacionInicial").value
        var Final = document.getElementById("dropdownEstacionFinal").value
        var Distance = document.getElementById("distance").value
        var get = url4+"?Initial="+Initial+"&Final="+Final+"&Distance="+Distance;
        if (Initial==""||Final==""||Distance==""){
            alert("you have unfinished spaces")
            return;
        }else{
            Http6.open(HttpMethod, get)
            Http6.send()
            Http6.onreadystatechange = (e) => {
                if(Http6.readyState === XMLHttpRequest.DONE) {
                    alert(Http6.responseText)
                }
            }

        }

    }

    function eliminarRuta() {
        var Initial = document.getElementById("dropdownEstaciones").value
        var Final = document.getElementById("dropdownParadas").value
        var get = url5+"?Estaciones="+Initial+"&Paradas="+Final;
        Http7.open(HttpMethod, get)
        Http7.send()
        Http7.onreadystatechange = (e) => {
            if(Http7.readyState === XMLHttpRequest.DONE) {
                alert(Http7.responseText)
            }
        }
    }

</script>

<body onload="all()">

<h1>Admin Page</h1>

<h2>Add station</h2>

    Name of new station<br>
    <input type="text" id="StopName" name="StopName" required><br><br>

    Position in X station<br>
    <input type="number" id="XPos" name="XAxis" required
           min="1" max="100"><br><br>

    Position in Y station<br>
    <input type="number" id="YPos" name="YAxis" required
           min="1" max="100"><br><br>

    <input type="submit" onclick="agregarEstacion()" value="Add new station">

<br><br>

<h2>Delete station</h2>
    Station you wish to remove<br>
    <select id="dropdownEstacionEliminar" name="NodeID" required>
    </select><br><br>

    <input type="submit" onclick="eliminarEstacion()" value="Eliminar estacion">

<br><br>

<h2>Add Route</h2>

    Select a starting point <br>
    <select id = "dropdownEstacionInicial" name="Initial" required>
    </select><br><br>


    Select a finishing point <br>
    <select id = "dropdownEstacionFinal" name="Final" required>
    </select><br><br>

    Select the distance between the two points <br>
    <input type="number" id="distance" name="Distance" required
           min="1" max="100"><br>
    <br>
    <input type="submit" onclick="agregarRuta()" value="Add route">

<br><br>

<h2>Delete Route</h2>

    <h4>Station</h4>
    <select id="dropdownEstaciones" onchange="paradasDisponibles()" name="Estaciones" required>
    </select>

    <h4>Stops</h4>
    <select id="dropdownParadas" name="Paradas" required>
    </select><br><br>

    <input type="submit" onclick="eliminarRuta()" value="Eliminar ruta">


<br><br>

<h2>Reservations</h2>

<form>
    <h4>How to view reservations</h4>
    <input type="button" onclick="reservaciones('Usuario')" value="Users">
    <input type="date" id="fecha" onchange="getTicketFecha()" name="Date" required min="2020-08-13" max="2021-01-01">

    <select id="dropdownReservaciones" onchange="porRuta()" name="Tickets">
    </select>
</form>


<table id="userTable">
</table>

</body>

</html>