# PRACTICA 1 #######################

	.data
	A: .word 3, 5, 7
	punter: .word 0

	.text
	.globl main
main:
	li $s1, 2
	sll $s1, $s1, 2
	la $s2, A
	addu $s3, $s1, $s2
	
	lw $s4, 0($s3)
	addiu $s0, $s4, 2
	
	subu $s5, $s3, $s1
	lw $s6, 0($s5)
	addu $s0, $s6, $s0
	
	addiu $s7, $s2, 4
	sw $s0, 0($s7)
	
	li $v0, 1
	move $a0, $s0
	syscall


	jr $ra		# main retorna al codi de startup

