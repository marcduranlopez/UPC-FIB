#version 330 core

//in vec3 fcolor;

in vec3 vertexF;
in vec3 normalF;

in vec3 matambF;
in vec3 matdiffF;
in vec3 matspecF;
in float matshinF;

uniform vec3 posFocus1;
uniform vec3 posFocus2;
uniform vec3 colFocus1;
uniform vec3 colFocus2;
uniform mat4 view;

//uniform int focusCam;

out vec4 FragColor;

// Valors per als components que necessitem dels focus de llum
//vec3 colFocus = vec3(0.8, 0.8, 0.8);
vec3 llumAmbient = vec3(0.2, 0.2, 0.2);
//vec3 posFocus = vec3(1, 0, 1);  // en SCA

/*

*/
vec3 components (vec3 NormSCO, vec3 L, vec4 vertSCO, vec3 colFocus)
{
    // Els vectors estan normalitzats

    // Inicialitzem color a Lambert
     vec3 colRes = llumAmbient * matambF;

    // Afegim component difusa, si n'hi ha
    if (dot (L, NormSCO) > 0)
      colRes = colRes + colFocus * matdiffF * dot (L, NormSCO);
    return (colRes);
    
----

    // Calculem R i V (Phong)
    if (dot(NormSCO,L) < 0)
      return colRes;  // no hi ha component especular

    vec3 R = reflect(-L, NormSCO); // equival a: normalize (2.0*dot(NormSCO,L)*NormSCO - L);
    vec3 V = normalize(-vertSCO.xyz);

    if ((dot(R, V) < 0) || (matshinF == 0))
      return colRes;  // no hi ha component especular

    // Afegim la component especular
    float shine = pow(max(0.0, dot(R, V)), matshinF);
    return (colRes + matspecF * colFocus * shine);
}



void main()
{
	
	
	// Pasar posicio del focus de llum en SCO
	//if(focusCam == 1) {
    vec3 posF = (view * vec4(posFocus1, 1.0)).xyz;
	// Direccio llum
    vec3 L1 = normalize(posF - vertexF.xyz);
	//}
	//else // Dixar posicio del focus de llum en SCA
	//{
    vec3 L2 = normalize(posFocus2 - vertexF.xyz);
	//}
	// Nomes la Normal i la L son "vcectors", els unics que es normalitzen
	vec3 NM = normalize(normalF);
	vec3 color = components(NM, L1, vec4(vertexF, 1),colFocus1) + components(NM, L2, vec4(vertexF, 1),colFocus2);
    
	FragColor = vec4(color, 1);
}
