const url='http://localhost:9080/cual';
var Http= new XMLHttpRequest();
const event1="clickNode";
const HttpMethod="GET";

async function xd(callback){
    Http.open(HttpMethod, url);
    Http.send();

    Http.onreadystatechange = (e) => {
        console.log(Http.responseText)
        var graph =JSON.parse(Http.responseText);
        s.graph.read(graph);
        s.bind(event1, function (node) {
            node.data.node.color="#4e1b99";
            s.refresh();
        });
        s.refresh();


    }
}

var s = new sigma(
    {
        renderer: {
            container: document.getElementById('sigma-container'),
            type: 'canvas',
            color:"#e1db00"
        },
        settings: {
            minArrowSize:8,
            minNodeSize: 20,
            arrowSizeRatio: 1

        }
    }
);

// Create a graph object

xd();
