españa <- read.table("clipboard",header = TRUE,sep='\t')
francia <-read.table("clipboard",header= TRUE,sep='\t')

summary(francia)
summary(españa)

n <- 64
mediae <- mean(españa$Distancia) #media de la distancia de la liga española
mediae
desve <- sd(españa$Distancia) #desviacion estandard de la distancia de la liga española
desve


mediaf <- mean(francia$Distancia) #media de la distancia de la liga francesa
mediaf
desvf <- sd(francia$Distancia) #desviacion estandard de la distancia de la liga francesa
desvf

diferencia <- mediae-mediaf
diferencia

# Calculos de Estadistico t
  #manual :
  s2 = (((n-1)*(desve^2))+((n-1)*(desvf^2)))/(n+n-2)
  s = sqrt(s2)
  se = s*sqrt((1/n)+(1/n))
  t = (mediae-mediaf)/se 
  t
  #t-test
  t.test(españa$Distancia, francia$Distancia , paired = FALSE)
  
#pruebas de normalidad
  #1 1 libreria necesaria para otra prueba de normalidad
  require(nortest)
    #prueba normalidad Distancia de españa
    ad.test(españa$Distancia)
    #prueba normalidad Distancia de francia
    ad.test(francia$Distancia)
  #2 qqnorm
    qqnorm(francia$Distancia,pch=19)
    qqline(francia$Distancia)

    qqnorm(españa$Distancia,pch=19)
    qqline(españa$Distancia)    
    

dif <- españa$Distancia - francia$Distancia

#Prueba de hipotesis + boxplot

datos <- data.frame(Distancia=c(españa$Distancia, francia$Distancia),
                    Liga=c('Distancia Liga Española', 'Distancia Liga Francesa') )
boxplot(Distancia ~ Liga, data=datos, las=1,
        xlab='Liga', ylab='Distancia Recorrida (km)')

t.test(x=españa$Distancia, y= francia$Distancia, alternative="two.sided",
       paired=FALSE, var.equal=FALSE, conf.level=0.975)

#Graficos temperatura-Distancia

plot(españa$Distancia,españa$Temperatura)
plot(francia$Distancia,francia$Temperatura)


#Calculos para la linea de regresion B6
  #mod.lm españa
  datos2 <- data.frame(D_T=c(españa$Distancia, españa$Temperatura),
                    timo=c('Distancia Liga Española', 'Temperatura en sus partidos') )
  mod.lm <- lm(D_T~timo , data = datos2)
  summary(mod.lm)

  #mod.lm francia
  datos2 <- data.frame(D_T=c(francia$Distancia, francia$Temperatura),
                     timo=c('Distancia Liga Francesa', 'Temperatura en sus partidos') )
  mod.lm <- lm(D_T~timo , data = datos2)
  summary(mod.lm)
  
  
  #linea regresion españa
par(cex.lab=1.2,cex.axis=1.2,las=1,font.lab=2,font.axis=3)
plot(españa$Distancia,españa$Temperatura,pch=19,col=4,cex=1.2)
abline(mod.lm,col=2,lwd=3)

#linea regresion francia
par(cex.lab=1.2,cex.axis=1.2,las=1,font.lab=2,font.axis=3)
plot(francia$Distancia,francia$Temperatura,pch=19,col=4,cex=1.2)
abline(mod.lm,col=2,lwd=3)
