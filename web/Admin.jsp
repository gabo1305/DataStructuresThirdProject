<html>

<title>Admin</title>
<script src="noBack.js"></script>

<script>
    function estaciones() {
        var d = new Date();
        var currentYear = d.getFullYear();
        var currentMonth = d.getMonth()+1;
        var yroptions = "<option value='0'> select</option>";

        for (var i = currentYear; i <currentYear+5;i++){
            yroptions += "<option value='"+i+"'>"+i+"</option>"
        }
        document.getElementById('dropdownEstaciones').innerHTML = yroptions;

    }
</script>

<body onload="estaciones()">


<h2>Seccion donde el admin escoge que hacer</h2>

<br>

<h3>Agregar ruta</h3>

<form >
    Select you starting point : <input type="text" name="Startingpoint"> <br><br>

    Select you Finish point : <input type="password" name="Finalpoint"> <br><br>

    select the distance between the two points : <input type="password" name="Distance"> <br><br>

    <input type="submit" value="Agregar ruta">
</form>

<br><br>


Con esto podemos escoger cual estacion tiene viajes pendientes
<form>
    <select id = "dropdownEstaciones">

    </select>
</form>


</body>

</html>