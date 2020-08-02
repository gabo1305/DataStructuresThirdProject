var Http= new XMLHttpRequest();


async function xd(callback){
    const url='http://localhost:9080/cual';
    Http.open("GET", url);
    Http.send();

    Http.onreadystatechange = (e) => {
        console.log("me quiero matar")
        console.log(Http.responseText)


        var graph =JSON.parse(Http.responseText);
        s.graph.read(graph);
        s.refresh();

    }
    console.log("por favor dios")
}

// Initialise sigma:
var s = new sigma(
    {
        renderer: {
            container: document.getElementById('sigma-container'),
            type: 'canvas'
        },
        settings: {
            minEdgeSize: 0.1,
            maxEdgeSize: 2,
            minNodeSize: 1,
            maxNodeSize: 8,
        }
    }
);

// Create a graph object

xd()