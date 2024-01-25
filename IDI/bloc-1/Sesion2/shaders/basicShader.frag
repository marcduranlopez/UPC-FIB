#version 330 core

out vec4 FragColor;
in vec4 out_colors;

void main() {
    FragColor = out_colors;
    
    /*
    if (int(gl_FragCoord.y)%16 == 0) discard;
    if (int(gl_FragCoord.y+1)%16 == 0) discard;
    if (int(gl_FragCoord.y+2)%16 == 0) discard;
    if (int(gl_FragCoord.y+3)%16 == 0) discard;
    if (int(gl_FragCoord.y+4)%16 == 0) discard;
    if (int(gl_FragCoord.y+5)%16 == 0) discard;
    if (int(gl_FragCoord.y+6)%16 == 0) discard;
    if (int(gl_FragCoord.y+7)%16 == 0) discard;
    
    

    if ((gl_FragCoord.x < 354.) && (gl_FragCoord.y < 354.)) FragColor = vec4(1.,1.,0.,1);
    else if ((gl_FragCoord.x < 354.) && (gl_FragCoord.y >= 354.)) FragColor = vec4(1.,0.,0.,1);
    else if ((gl_FragCoord.x >= 354.) && (gl_FragCoord.y < 354.)) FragColor = vec4(0.,1.,0.,0);
    else if ((gl_FragCoord.x >= 354.) && (gl_FragCoord.y >= 354.)) FragColor = vec4(0.,0.,1.,0);
    
    */
}

