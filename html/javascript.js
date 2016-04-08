// Variables globales
var interval;

// Cuando el documento (html) este listo
$(document).ready(function() {
    
    // Le damos al boton submit del formulario el evento click que lanzara la funcion enviar Form
    $("#submit").click(enviarForm);
    
    // Le damos al div tamaño el evento mousedown que lanzara la funcion enviar escala 
    $("#tamaño").mousedown(escala);
    
    // Le damos al div tamaño el evento mauseup que lanzara la funcion para restaurar sus dimensiones originales 
    $("#tamaño").mouseup(restaura);
    
    // Le damos al boton cambiaColor la funcion cambiaColor
    $("#cambiaColor").click(cambiaColor);
    
    // Le damos al div desplegable la funcion despliega
    $("#desplegable").click(despliega);
    
    
});

// Al hacer click en el submit.
function enviarForm(e) {
    
    // Primero prevenimos que el boton submit mande el formulario (asi no recargara la pagina)
    e.preventDefault();
    
    // Guardamos los valores de lo inputs
    var email = $("#email").val();
    var password = $("#password").val();
    
    // Escribimos en los div feedback los valores de email y password
    $("#feedbackEmail").html("Valor: " + email);
    $("#feedbackPassword").html("Valor: " + password);
    
    
}

// Funcion para escalar el div
function escala() {
    
    $("#tamaño").width(function(n, c) {
        return c + 1;
    });
        
    $("#tamaño").height(function(n, c) {
        return c + 1;
    });
    
    interval = setTimeout(escala, 10);
    
}

// Restaura el div tamaño a su tamaño original
function restaura() {
    
    // Limpiamos el TimeOut
    clearInterval(interval);
    
    // Restaura el alto y ancho del div.
    $("#tamaño").css({"width" : "150px", "height" : "150px"})
    
}

// Funcion para cambiar de color el boton
function cambiaColor() {
    
    // Asignamos el nombre de los colores a un array
    var colores = ["rojo", "azul", "amarillo", "verde", "rosa", "naranja"];
    
    // Primero borramos todas las clases y luego añadimo una clase aleatoria del array
    $("#cambiaColor").removeClass().addClass(colores[randomRange(0, 5)]);
    
}

// Funcion para desplegar el div desplegable
function despliega() {
    
    // Al hacer click en el desplegable el contenido 
    $("#contenido").toggle("fast", function (e) {
        
        // Guardamos en la variable el estado actual del atributo css display
        var eActual = $(this).css("display");
        
        // Si es igual a none, significa que esta cerrado, sino, esta abierto
        if(eActual == "none") {
            $(this).html("¡Estoy Cerrado!");
        } else {
            $(this).html("¡Estoy Abierto!");
        }
    });
    
}

// Funcion Random entre un minimo y un maximo
function randomRange(min, max) {
	// Si queremos numeros enteros con esta formula conseguimos que todos los numeros tengan la misma probabilidad de salir
	var resultado = Math.floor((Math.random() * (max - min + 1)) + min);
    return resultado;
}
