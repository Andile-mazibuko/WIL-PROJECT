var myselect = document.getElementById("select");
var bid = document.getElementById("bid");
var bedrooms = document.getElementById("bedrooms");
var bathrooms = document.getElementById("bathrooms");
var garages = document.getElementById("garage");

var kilometres = document.getElementById("kilometres");
var geartype = document.getElementById("geartype");
var fueltype = document.getElementById("fueltype");
var model = document.getElementById("model");

myselect.addEventListener("change", () =>{
    
    
    if(myselect.value.includes("house"))
    {
        kilometres.classList.remove("visible");
        geartype.classList.remove("visible");
        model.classList.remove("visible");
        fueltype.classList.remove("visible");
      
        //bid.classList.add("visible");
        bedrooms.classList.add("visible");
        bathrooms.classList.add("visible");
        garages.classList.add("visible");
    }
    else if(myselect.value.includes("car"))
    {
       
        bedrooms.classList.remove("visible");
        bathrooms.classList.remove("visible");
        garages.classList.remove("visible");
        
        kilometres.classList.add("visible");
        geartype.classList.add("visible");
        model.classList.add("visible");
        fueltype.classList.add("visible");
    }

});

/*function removeBid(elementVaule, bid)
{
    if(elementVaule.value.includes("rent"))
    {
        bid.classList.remove("visible");
    }
}



function findValueofRadio(radio)
{
    let radioValue = "";
    for(let i = 0; i < radio.length; i++)
    {
        if(radio[i].checked)
        {
            radioValue = radio[i].value;
            break;
        }
    }
    return radioValue;
}*/