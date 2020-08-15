const url='http://localhost:9080/Update';
var Http= new XMLHttpRequest();
var Http2=new XMLHttpRequest();
const event1="clickNode";
const clickEdge="clickEdge";
const HttpMethod="GET";
const getPrice='http://localhost:9080/EdgesPrice'
var BackIdentifier=null;
var FrontIdentifier=null;

async function xd(callback){
    Http.open(HttpMethod, url);
    Http.send();

    Http.onreadystatechange = (e) => {
        //console.log(Http.responseText)
        var graph =JSON.parse(Http.responseText);
        s.graph.read(graph);
        s.bind(event1, function (node) {
           if (BackIdentifier!=null)BackIdentifier.color="#000";
            BackIdentifier=FrontIdentifier;
            FrontIdentifier=node.data.node;
            //node.data.node.color="#4e1b99";
            if(BackIdentifier!=null)BackIdentifier.color="#4e1b99"
            if(FrontIdentifier!=null)FrontIdentifier.color="#19ff00"
            if(BackIdentifier!=null && FrontIdentifier!=null){
                //console.log("Back es BackIdentifier "+BackIdentifier)
               // console.log("Front es "+FrontIdentifier)
                var finalUrl=getPrice+"?From="+BackIdentifier.id+"&To="+FrontIdentifier.id;
                console.log(finalUrl)
                Http2.open(HttpMethod,finalUrl)
                Http2.send();
                Http2.onreadystatechange=(e)=>{
                    if(Http2.readyState === XMLHttpRequest.DONE){
                        alert(Http2.responseText)
                    }
                }
                BackIdentifier.color="#000";
                FrontIdentifier.color="#000";
                BackIdentifier=null;
                FrontIdentifier=null;



            }
            s.refresh();
        });
        s.bind(clickEdge, function (edge) {
            var from=edge.data.source;
            var to=edge.data.target;
            console.log("El source es "+from)
            console.log("El target es "+to)
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
            color:"#e1db00",

        },
        settings: {
            minArrowSize:8,
            minNodeSize: 20,
            arrowSizeRatio: 1,
            edgeLabelSize: 'proportional',
            defaultEdgeLabelColor: "#ff0e00",
            //minEdgeSize:10,

        }
    }
);

// Create a graph object

xd();
