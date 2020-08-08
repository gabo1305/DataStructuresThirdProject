<html>

<title>Admin</title>
<script src="noBack.js"></script>

<script>
    const url='http://localhost:9080/cual';
    const Http= new XMLHttpRequest();
    const HttpMethod="GET";
    var text;

    function getText() {
        Http.open(HttpMethod, url);
        Http.send();
        Http.onreadystatechange = (e) => {
            console.log(Http.responseText)
            text = Http.responseText;
            estaciones()
        };
    }
    var text1 = '{"nodes":[' +
        '{"id":"0","label":"Heredia","x":6.0,"y":15.0,"size":5.0},' +
        '{"id":"1","label":"Santo Domingo","x":3.0,"y":13.0,"size":5.0},' +
        '{"id":"2","label":"Tibas","x":5.0,"y":10.0,"size":5.0},{"id":"3","label":"Moravia","x":5.0,"y":7.5,"size":5.0},{"id":"4","label":"San Jose","x":11.0,"y":17.0,"size":5.0},{"id":"5","label":"San Pedro","x":13.0,"y":13.0,"size":5.0},{"id":"6","label":"Guadalupe","x":13.0,"y":9.0,"size":5.0},{"id":"7","label":"Sabanilla","x":16.0,"y":14.0,"size":5.0},{"id":"8","label":"Curridabat","x":17.0,"y":12.0,"size":5.0},{"id":"9","label":"Zapote","x":16.0,"y":17.0,"size":5.0},{"id":"10","label":"Tres Rios","x":21.0,"y":13.0,"size":5.0},{"id":"11","label":"Cartago","x":19.0,"y":10.0,"size":5.0},{"id":"12","label":"Paraiso","x":16.5,"y":8.0,"size":5.0}],\n' +
        '  "edges":[{"id":"0","source":"0","target":"1"},{"id":"1","source":"1","target":"0"},{"id":"2","source":"1","target":"2"},{"id":"3","source":"2","target":"1"},{"id":"4","source":"2","target":"4"},{"id":"5","source":"3","target":"2"},{"id":"6","source":"3","target":"6"},{"id":"7","source":"4","target":"2"},{"id":"8","source":"4","target":"5"},{"id":"9","source":"4","target":"9"},{"id":"10","source":"5","target":"4"},{"id":"11","source":"5","target":"6"},{"id":"12","source":"5","target":"8"},{"id":"13","source":"6","target":"3"},{"id":"14","source":"6","target":"5"},{"id":"15","source":"7","target":"4"},{"id":"16","source":"7","target":"5"},{"id":"17","source":"8","target":"5"},{"id":"18","source":"8","target":"10"},{"id":"19","source":"9","target":"4"},{"id":"20","source":"9","target":"10"},{"id":"21","source":"10","target":"7"},{"id":"22","source":"10","target":"9"},{"id":"23","source":"10","target":"11"},{"id":"24","source":"11","target":"10"},{"id":"25","source":"11","target":"12"},{"id":"26","source":"12","target":"11"}]}\n';

    function all() {
        getText()
    }

    function estaciones() {
        obj = JSON.parse(text);
        var estacionOption = "<option name=''> select</option>"

        console.log(obj.nodes[0].label)

        for (var i = 0; i<obj.nodes.length;i++){
            estacionOption += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
        }
        document.getElementById('dropdownEstacionInicial').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionFinal').innerHTML = estacionOption;

    }




</script>

<body onload="all()">

<h2>Seccion donde el admin escoge que hacer</h2>

<br>

<h3>Agregar ruta</h3>

<form  action="/newRoute">
    Select a starting point <br>
    <select id = "dropdownEstacionInicial" name="Initial" required>
    </select>


    Select a finishing point <br>
    <select id = "dropdownEstacionFinal" name="Final" required>
    </select>

    Select the distance between the two points <br>
    <input type="number" name="Distance" required><br>
    <br>
    <input type="submit" value="Agregar ruta">
</form>


<h3>Eliminar ruta</h3>



</body>

</html>