# PRACTICA 1 #######################

	.data
	cadena: .byte -1,-1,-1,-1,-1,-1
	vec: .word 5, 6, 8, 9, 1

	.text
	.globl main
main:
	li $s0, 0
	
while:  li $t0, 5
	bge $s0, $t0, fi
	
	la $s3, vec
	sll $s1, $s0, 2
	addiu $s3, $s3, 16
	
	subu $s4, $s3, $s1
	lw $s5, 0($s4)
	addiu $s6, $s5, 48
	la $s7, cadena
	addu $s1, $s7, $s0
	sb $s6, 0($s1)
	
	addiu $s0, $s0, 1
	b while

fi:
	addu $s2, $s7, $s0
	sb $zero, 0($s2)
		
	li $v0, 4
	move $a0, $s7
	syscall


	jr $ra		# main retorna al codi de startup

