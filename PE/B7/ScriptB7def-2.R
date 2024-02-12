Call:
  lm(formula = y ~ x)

Residuals:
  Min      1Q  Median      3Q     Max 
-1.3804 -0.4106 -0.1458  0.4733  1.4513 

Coefficients:
  Estimate Std. Error t value Pr(>|t|)    
(Intercept) *%&{$?^^&   0.262377 160.666  < 2e-16 ***
    x           -0.014379   0.004249  -3.385  0.00311 ** 
    ---
    Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1
  
  Residual standard error: 0.7046 on 19 degrees of freedom
  Multiple R-squared:  0.3761,	Adjusted R-squared:  0.3433 
  F-statistic: 11.46 on 1 and 19 DF,  p-value: 0.003111
--------------------------------------------------------------
  
b0 = 0;         sb0 = 0.262377; tb0 = 160.666; pb0 = 2e-16
b1 = -0.014379; sb1 = 0.004249; tb1 = -3.385; pb1 = 0.00311
# si falta alguno: t=b/s
tb0 = b0/sb0; tb0
sb0 = b0/tb0; sb0

df = 19


# PREGUNTA: ¿Cuánto vale la estimación del término independiente?
b1

# PREGUNTA: Extremo superior de un intervalo de confianza 95% para la pendiente.
prob = 0.95
alfa = 1-prob; alfa
t = qt(1-alfa/2,df); t
b0-t*sb0

# PREGUNTA: Responda con el estadístico de la prueba ß0=0.
tb0

# PREGUNTA: Responda con el estadístico de la prueba ß1=0.
tb1

# PREGUNTA: ¿Podríamos rechazar con estos datos ß1=-0.1? (use riesgo a=1%; 0: no, 1: sí).
B1 = 0.05
alfa = 0.02
t = qt(1-alfa/2,df); t
ifelse((b1-B1)/sb1>t,"rebutgem H0","no rebutgem H0")

# PREGUNTA: ¿Rechazaría la hipótesis de que la recta realmente es horizontal? (0: no, 1: sí)
B1 = 0
ifelse((b1-B1)/sb1>tb1,"rebutgem H0","no rebutgem H0")

# PREGUNTA: P-valor de la prueba ß0=0.
pb0

# PREGUNTA: P-valor de la prueba ß1=0.
pb1

# PREGUNTA: En la salida hay un valor corrompido. ¿Puede recuperar el valor original?
# si falta alguno: t=b/s

# PREGUNTA: Diga el valor que se ha estimado para la desviación típica del término aleatorio del modelo.
E = 
  
  
  
  
b0 = 0; tb0 = 160.666; pb0 = 0.262377
b1 = -0.014379; sb1 = 0.004249; tb1 = -3.385; pb1 = 0.00311
desv = 0.7046; coef = 0.3761; df = 19
sb0 = b0/tb0; sb0
tb0

sb1

tb1

b1 - qt(0.975,df) * sb1


pb1

coef


# ¿Podríamos rechazar con estos datos ??1=0.001? (use riesgo ??=10%; 0: no, 1: sí)
t = (b1-0.014)/sb1
ifelse(t > qt(0.90,df), 1, 0)


t = (b0-(42))/sb0
ifelse(t > qt(0.90,df), 1, 0)








dades = read.table("clipboard", header=TRUE)
model = summary(lm(dades$Preu ~ dades$Capacitat))
# Quant val l'estimació del coeficient lineal (pendent de larecta)?
  b1 = model$coefficients[2]; b1
  # Quin és el valor de la variància residual? Arrodoniu al'enter més pròxim.
varRes = round((model$sigma)^2); varRes
# Quin és el valor de l'estadístic 't' que està associat aaquesta prova (el preu de l'ordinador s'incrementa en 4 euros per cada Gigabyte de més que te el disc dur)?
  sb1 = model$coefficients[4];
  t = (b1 - 4)/sb1; t
  # Per a un risc ?? del 4% bilateral, quin seria el punt críticper rebutjar la hipòtesi anterior?
  alfa = 1/100
  df = 23 -2 # df = length(dades$Preu) -2 = model$df[2]
  puntCritic = qt(1-alfa/2,df); puntCritic
  # Feu els càlculs per trobar el valor del coeficient de determinació R 2 del model "Preu" en funció de "Capacitat", amb quatre decimals exactes.
  r2 = model$r.squared; r2
  # Quant val el residu que proporciona el model per a l'ordinador que costa 880 euros amb capacitat 200 GB?
b0 = model$coefficients[1];
residu = 735 - b0 - b1*140; residu
# Trobeu un interval de confiança al 95% per al preu d'unordinador de 200 GB de capacitat al disc dur.
  preu = dades$Preu
  
  capacitat = dades$Capacitat
  interval.lm = lm(preu~capacitat)
  dataframe = data.frame(capacitat = 140)
  p7 = predict(interval.lm, dataframe, interval="predict")
  p7[2]; p7[3]
  
  # Suposeu que hem descobert un error contable, i que a totsels preus del proveïdor 3 els mancava l'IVA (21%). Refeu els càlculs, i digueu com queda ara el terme independent de la recta de regressió.
  for (i in 1:length(dades$Preu)) { if (dades$Proveïdor[i] == 1) dades$Preu[i] = dades$Preu[i] + 0.21*dades$Preu[i] }
  model = summary(lm(dades$Preu ~ dades$Capacitat))
  b0 = model$coefficients[1]; b0
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  muX = -51.76883
  muY = 8.34003
  sX = 48.55286
  sY = 7.72628
  sXY = 62.62339 
  n = 36
  # ¿Cuánto vale la pendiente estimada?
  b1 = sxy/sx^2; b1 # rxy = sxy/(sx*sy)
  # b1 = rxy*(sy/sx)
  # De acuerdo con la hipótesis: ??1=0.005, diga qué valor toma el estadístico de la prueba
  s2 = ((n-1)*(sy^2-b1*sxy))/(n-2)
  sb1 = sqrt(s2/((n-1)*sx^2))
  t = (b1-0.005)/sb1; t
  # Obtenga una estimación de la variancia residual
  s2
  # ¿Se podría rechazar la hipótesis: ??0=-8.1? (use riesgo ??=10%; 0: no, 1: sí)
  b0 = y - b1*x
  sb0 = sqrt(s2*(1/n + x^2/((n-1)*sx^2)))
  t = (b0-(-8.1))/sb0
  alfa = 10/100
  ifelse(t > qt(1-alfa/2,n-2), 1, 0)
  # Diga el valor que se ha estimado para la desviación típica del término aleatorio del modelo
  s = sqrt(s2); s
  # De acuerdo con la hipótesis: ??0=-8.1, diga qué valor toma el estadístico de la prueba 
  t
  # ¿De cuántos grados de libertad dispone este modelo para estimar los parámetros? 
  n-2
  
  
  
  
  
  
  
  
  b1 = sXY/sX^2; b1
  b0 = muY-b1*muX; b0
  s2 =(((n-1)*sY^2)-(b1*(n-1)*sXY))/(n-2); s2
  sb0 = sqrt(s2*(1/n+muX^2/((n-1)*sX^2))); sb0
  sb1 = sqrt(s2/((n-1)*sX^2)); sb1
  R2 = (sXY/(sX*sY))^2; R2
  
  # Pendiente
  b1
  
  # término independiente
  b0
  
  # ¿Se podría rechazar la hipótesis: ß0=-28? (use riesgo a=5%; 0: no, 1: sí).
  B0 = -41.6
  alfa = 0.02
  t = qt(1-alfa/2,n-2); t
  ifelse((b0-B0)/sb0>t,'rebutjar H','no rebutjar H')
  
  B1 = -0.03
  alfa = 0.02
  t = qt(1-alfa/2,n-2); t
  ifelse((b1-B1)/sb1>t,'rebutjar H','no rebutjar H')
  
  # De acuerdo con la hipótesis: ß0=B0, diga qué valor toma el estadístico de la prueba.
  B0 = -99.6
  t = (b0-B0)/sb0; t
  
  B1 = -0.03
  t = (b1-B1)/sb1; t
  
  # ¿Qué parte (en %) de la variabilidad total explica la variable X?
  R2*100
  
  # factores diferentes de X
  100-R2*100
  
  # Obtenga una estimación de la variancia residual
  V = ((n-1)*sY^2-b1*(n-1)*sXY)/(n-2); V
  
  # Coeficiente de determinación asociado al modelo
  R2
  
  # Grados de libertad del modelo para estimar los parámetros
  n - 2
  
  # Valor que se ha estimado para la desviación típica
  s = sqrt(s2); s
  
  
  
  
  # componente de la descomposición de la variabilidad que se atribuye al error aleatorio de los datos
  (n-1)*sY^2-b1*(n-1)*sXY
  
  # halle el coeficiente de determinación asociado al modelo
  b1*(n-1)*sXY/((n-1)*sY^2)
  
  # Cuánto vale la media de los cuadrados explicados por el modelo?
  b1*(n-1)*sXY
  
  # media de la variabilidad total de Y
  (n-1)*sY^2
  
  # componente de descomposición de la variabilidad que quedaría explicada por X
  b1*(n-1)*sXY
  
  # estadístico de la prueba que se resuelve mediante la tabla ANOVA
  F = b1*(n-1)*sXY*(n-1)/((n-1)*sY^2-b1*(n-1)*sXY); F
  
  # valor P en la prueba de si el factor X reduce la variabilidad en la respuesta Y
  1-pf(F,1,n-2)	# si F >= 0
  pf(F,1,n-2)		# si F < 0
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  dades = read.table("clipboard", header=TRUE)
  model = summary(lm(dades$score ~ dades$seg))
  # Dar la estimación del parámetro lineal (pendiente de larecta) del modelo de regresión lineal para la relación entre la longitud del anuncio y el resultado de la encuesta
b1 = model$coefficients[2]; b1
# Dar el error estándar del estimador anterior
sb1 = model$coefficients[4]; sb1
# Con un riesgo alfa del 5%, ¿podemos concluir que la longitud del anuncio y la puntuación del test de memoria están linealmente relacionados? (1: si, 0: no)
alfa = 1/100
n = length(dades$seg)
tb1 = model$coefficients[6] # tb1 = b1/sb1
ifelse(tb1 > qt(1-alfa/2,n-2), 1, 0)
# ¿Qué longitud tendría un anuncio visto por cierto individuo, el cual le hubiera asignado una puntuación de 0?
  b0 = model$coefficients[1] 
  (27-b0)/b1
# ¿Qué puntuación se obtendría de un individuo que ve un anuncio de 35 segundos?
  b0 + b1*15
# Dar un intervalo de confianza del 95% de la predicción anterior
seg = dades$seg
score = dades$score
interval.lm = lm(score~seg)
dataframe = data.frame(seg = 15)
p6 = predict(interval.lm, dataframe, interval="predict", level=0.99)
p6[2]; p6[3]
# Estimar por IC del 95% la puntuación esperada de todos los anuncios que duran 35 segundos
p7 = predict(interval.lm, dataframe, interval="confidence", level=0.99)
p7[2]; p7[3]
# Obtenga una estimación del coeficiente de determinación R2
r2 = model$r.squared; r2
# Obtenga el diagrama de residuos estandarizados vs la duración del anuncio, y diga cuál de las siguientes es la salida correcta
plot(lm(dades$score ~ dades$seg))



# Preguntas de otras ejecuciones
# Dar la estimación del parámetro independiente (término constante) del modelo de regresión lineal para la relación entre la longitud del anuncio y el resultado de la encuesta
# b0 = model$coefficients[1]; b0
# Dar el error estándar del estimador anterior
# sb0 = model$coefficients[3]; sb0
















dades <- read.table("clipboard",header=TRUE)
X = dades$vol
Y = dades$perc
n = length(dades$temp); n
sX2 = (sum(X^2)-(sum(X)^2)/n)/(n-1); sX2
sY2 = (sum(Y^2)-(sum(Y)^2)/n)/(n-1); sY2
sXY = (sum(X*Y)-(sum(X)*sum(Y)/n))/(n-1); sXY

# PREGUNTA 1
b1 = sXY/sX2; b1

# PREGUNTA 2
s2 = (n-1)*(sY2-b1*sXY)/(n-2); s2
sb1 = sqrt(s2/((n-1)*sX2)); sb1

# PREGUNTA 3
alfa = 0.05
t = qt(1-alfa/2,n-2); t
ifelse(b1/sb1 > t,"rebutgem H0","no rebutgem H0")

# PREGUNTA 4
x = 4
b0 = mean(dades$perc)-b1*mean(dades$vol); b0
y = mean(dades$perc)-mean(b0+b1*(dades$vol-x)); y

# PREGUNTA 5
Xi = dades$temp
Yi = dades$perc
sX2i = (sum(Xi^2)-(sum(Xi)^2)/n)/(n-1); sX2i
sY2i = (sum(Yi^2)-(sum(Yi)^2)/n)/(n-1); sY2i
sXYi = (sum(Xi*Yi)-(sum(Xi)*sum(Yi)/n))/(n-1); sXYi
b1i = sXYi/sX2i; b1i

# PREGUNTA 6
s2i = (n-1)*(sY2i-b1i*sXYi)/(n-2); s2i
sb1i = sqrt(s2i/((n-1)*sX2i)); sb1i
Ti = b1i/sb1i; Ti

# PREGUNTA 7
Pi = 2*(1-pt(Ti,n-2)); Pi

# PREGUNTA 8
sXi = sqrt(sX2i)
sYi = sqrt(sY2i)
rXYi = sXYi/(sXi*sYi); rXYi

# PREGUNTA 9
xi = 8
b0i = mean(Yi)-b1i*mean(Xi); b0i
yi = b0i+b1i*xi; yi

# PREGUNTA 10 ----- 61.67891, 70.62998
prob = 0.95
alfa = 1-prob; alfa
t = qt(1-alfa/2,n-2); t

si = sqrt(s2i)
ei = yi - t*si*sqrt((1/n+(xi-mean(Xi))^2/sum(Xi-mean(Xi)^2))); ei
es = yi + t*si*sqrt((1/n+(xi-mean(Xi))^2/sum(Xi-mean(Xi)^2))); es

IC = c(ei,es); IC
