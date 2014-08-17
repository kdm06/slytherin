jQuery(function($){
    /*var stageWidth;
    function resize(){
        stageWidth = $(".stage").innerWidth();
        
    }
    
    resize();*/
    var host = "http://192.168.1.101:8080/";
    Chart.defaults.global.scaleFontColor =  "#fff";
    Chart.defaults.global.responsive = true;
    
    var monthCrime = document.getElementById("chart-crime-month").getContext("2d");
    var monthCrimeDataColors = [
    {
        color:"#9d1bd9",
        highlight: "#a726e3"
    },
    {
        color: "#d91bce",
        highlight: "#e527da"
    },
    {
        color: "#d91b55",
        highlight: "#e62963"
    },
    {
        color: "#ec2025",
        highlight: "#f42a2f"
    },
    {

        color: "#206dec",
        highlight: "#2b78f5"
    },
    {
        color: "#206dec",
        highlight: "#2b78f5"
    },
        {
        value: 70,
        color: "#20ecd6",
        highlight: "#2af4de",
        label: "PARRICIDE"
    },
        {
        color: "#206dec",
        highlight: "#2b78f5"
    },
        {
        color: "#50ec20",
        highlight: "#58f029"
    },
        {
        color: "#eca720",
        highlight: "#f4b02c"
    }
    ];
    
    
    /**CITY**/
    var cityCrime = document.getElementById("chart-city-crimes").getContext("2d");
    
    var cityCrimeData = {
    labels: ["PROSTITUTION", "THEFT", "MURDER", "KIDNAPPING", "ARSON", "RAPE", "PATRICIDE","MATRICIDE","HOMICIDE","SUICIDE"],
    datasets: [
        {
            label: "My First dataset",
            fillColor: "#d91b55",
            strokeColor: "rgba(220,220,220,0.8)",
            highlightFill: "#e62963",
            highlightStroke: "rgba(220,220,220,1)",
            data: [15, 12, 20, 18, 7, 5, 30,41,34,2]
        }
    ]
    };
    
    var monthCrimeGraph = new Chart(cityCrime).Bar(cityCrimeData, {
        barShowStroke : false,
        barValueSpacing : 15,
        scaleGridLineColor : "#051015"
    });
    
    /**endof CITY**/
    
    
    /**CRIME**/
    var crimeInCity = document.getElementById("chart-crimes").getContext("2d");
    
    var crimeInCityData = {
    labels: ["Manila", "Caloocan", "Las Piñas", "Makati", "Malabon", "Mandaluyong", "Marikina","Muntinlupa","Navotas","Parañaque","Pasay","Pasig","Quezon City","San Juan","Taguig","Valenzuela"],
    datasets: [
        {
            label: "My First dataset",
            fillColor: "#9d1bd9",
            strokeColor: "rgba(220,220,220,0.8)",
            highlightFill: "#a726e3",
            highlightStroke: "rgba(220,220,220,1)",
            data: [2, 3, 1, 5, 7, 5, 11,6,1,2,5, 11,6,1,2,12]
        }
    ]
    };
    
    var crimeInCityGraph = new Chart(crimeInCity).Bar(crimeInCityData, {
        barShowStroke : false,
        barValueSpacing : 15,
        scaleGridLineColor : "#051015"
    });
    
    $("#filter").click(function(){
        var month = $( "#filter-month" ).val();
        var city = $("#filter-city").val();
        var crime = $("#filter-crime").val();
        
        if(city == "null" && crime == "null"){
            $(".panel.active").removeClass("active");
            $(".display-all").addClass("active");
        }else if(city != "null" && crime == "null"){
            $(".panel.active").removeClass("active");
            $(".display-city-crimes").addClass("active");
        }else if(city == "null" && crime != "null"){
            $(".panel.active").removeClass("active");
            $(".display-crimes-cities").addClass("active");
        }else{
            $(".panel.active").removeClass("active");
            $(".display-total-crime").addClass("active");
        }
    });    
    /**endof CRIME**/
    loadDataAll();
    
    function loadDataAll(){
        var monthCrimeData = [];
       
        $.getJSON( host+ "slytherin-isigaw/crime/report/8/2014", function(data){
            console.log(data);
            var counter = 0;
            $.each(data,function(key,val){
                monthCrimeData.push({value: val.totalEvents,
                        color:monthCrimeDataColors[counter].color,
                        highlight: monthCrimeDataColors[counter].highlight,
                        label: val.crimeType});
                counter++;
            });
            
             var monthCrimeGraph = new Chart(monthCrime).PolarArea(monthCrimeData, {
                    scaleBackdropColor : "#50be11",
                    segmentShowStroke  : false,
                    scaleLineColor:"#051015"
                });

                $.each(monthCrimeData,function(key,val){
                    $("#chart-crime-month-legend ul").append("<li><span style='background:"+val.color+"'></span>"+val.label+"</li>");
                });
        });
    }
});