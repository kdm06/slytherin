jQuery(function($){
    /*var stageWidth;
    function resize(){
        stageWidth = $(".stage").innerWidth();
        
    }
    
    resize();*/
    
    Chart.defaults.global.scaleFontColor =  "#fff";
    Chart.defaults.global.responsive = true;
    
    var monthCrime = document.getElementById("chart-crime-month").getContext("2d");
   
    var monthCrimeData = [
    {
        value: 150,
        color:"#9d1bd9",
        highlight: "#a726e3",
        label: "PROSTITUTION"
    },
    {
        value: 175,
        color: "#d91bce",
        highlight: "#e527da",
        label: "THEFT"
    },
    {
        value: 100,
        color: "#d91b55",
        highlight: "#e62963",
        label: "MURDER"
    },
    {
        value: 40,
        color: "#ec2025",
        highlight: "#f42a2f",
        label: "KIDNAPPING"
    },
    {
        value: 125,
        color: "#206dec",
        highlight: "#2b78f5",
        label: "ARSON"
    },
    {
        value: 10,
        color: "#206dec",
        highlight: "#2b78f5",
        label: "RAPE"
    },
        {
        value: 70,
        color: "#20ecd6",
        highlight: "#2af4de",
        label: "PARRICIDE"
    },
        {
        value: 80,
        color: "#206dec",
        highlight: "#2b78f5",
        label: "MARRICIDE"
    },
        {
        value: 45,
        color: "#50ec20",
        highlight: "#58f029",
        label: "HOMICIDE"
    },
        {
        value: 90,
        color: "#eca720",
        highlight: "#f4b02c",
        label: "SUICIDE"
    }
    ];
 
    var monthCrimeGraph = new Chart(monthCrime).PolarArea(monthCrimeData, {
        scaleBackdropColor : "#50be11",
        segmentShowStroke  : false,
        scaleLineColor:"#051015"
    });
    
    $.each(monthCrimeData,function(key,val){
        $("#chart-crime-month-legend ul").append("<li><span style='background:"+val.color+"'></span>"+val.label+"</li>");
    });
    
    
    /**CITY**/
    var cityCrime = document.getElementById("chart-city-crimes").getContext("2d");
    
    var cityCrimeData = {
    labels: ["PROSTITUTION", "THEFT", "MURDER", "KIDNAPPING", "ARSON", "RAPE", "PARRICIDE","MARRICIDE","HOMICIDE","SUICIDE"],
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
});