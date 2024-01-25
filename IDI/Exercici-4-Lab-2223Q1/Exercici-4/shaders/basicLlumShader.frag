#version 330 core

in vec3  fmatamb;
in vec3  fmatdiff;
in vec3  fmatspec;
in float fmatshin;
in vec3  fvertex;
in vec3  fnormal;

const vec3 llumAmbient = vec3(0.1, 0.1, 0.1);

uniform mat4 TG;
uniform mat4 Proj;
uniform mat4 View;

uniform vec3 posFocus1;
uniform vec3 posFocus2;
uniform vec3 posFocus3;
uniform vec3 posFocus4;

uniform vec3 posFocusLinterna;

uniform vec3 colFocus1;
uniform vec3 colFocus2;

out vec4 FragColor;


vec3 Ambient() {
  return llumAmbient*fmatamb;
}

vec3 Difus (vec3 NormSCO, vec3 L, vec3 colFocus)
{
  // Fixeu-vos que SOLS es retorna el terme de Lambert!
  // S'assumeix que els vectors que es reben com a paràmetres estan normalitzats
  vec3 colRes = Ambient();
  if (dot (L, NormSCO) > 0)
    colRes = colFocus * fmatdiff * dot (L, NormSCO);
  return (colRes);
}

vec3 Especular (vec3 NormSCO, vec3 L, vec4 vertSCO, vec3 colFocus)
{
  // Fixeu-vos que SOLS es retorna el terme especular!
  // Assumim que els vectors estan normalitzats
  vec3 colRes = Difus(NormSCO, L, colFocus);
  // Si la llum ve de darrera o el material és mate no fem res
  if ((dot(NormSCO,L) < 0) || (fmatshin == 0))
    return colRes;  // no hi ha component especular

  vec3 R = reflect(-L, NormSCO); // equival a: 2.0*dot(NormSCO,L)*NormSCO - L;
  vec3 V = normalize(-vertSCO.xyz); // perquè la càmera està a (0,0,0) en SCO

  if (dot(R, V) < 0)
    return colRes;  // no hi ha component especular

  float shine = pow(max(0.0, dot(R, V)), fmatshin);
  return (colRes + fmatspec * colFocus * shine);
}

void main()
{
    vec3 posF1 = (View * vec4(posFocus1, 1.0)).xyz;
    vec3 L1 = normalize(posF1 - fvertex.xyz);
    
    vec3 posF2 = (View * vec4(posFocus2, 1.0)).xyz;
    vec3 L2 = normalize(posF2 - fvertex.xyz);
    
    vec3 posF3 = (View * vec4(posFocus3, 1.0)).xyz;
    vec3 L3 = normalize(posF3 - fvertex.xyz);
    
    vec3 posF4 = (View * vec4(posFocus4, 1.0)).xyz;
    vec3 L4 = normalize(posF4 - fvertex.xyz);
    
    vec3 posF5 = (View * vec4(posFocusLinterna, 1.0)).xyz;
    vec3 L5 = normalize(posF5 - fvertex.xyz);
    
    vec3 NM = normalize(fnormal);
    
    vec3 color = Especular(NM, L1, vec4(fvertex, 1),colFocus1) + Especular(NM, L2, vec4(fvertex, 1),colFocus1) + Especular(NM, L3, vec4(fvertex, 1), colFocus1) + Especular(NM, L4, vec4(fvertex, 1),colFocus1) + Especular(NM, L5, vec4(fvertex, 1),colFocus2);
    
	FragColor = vec4(color, 1);
}
