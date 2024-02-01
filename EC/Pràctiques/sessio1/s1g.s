# PRACTICA 1 #######################

	.data
	fib: .space 40

	.text
	.globl main
main:
	li $s0, 2
	la $t3, fib
	li $t1, 1
	sw $zero, 0($t3)
	sw $t1, 4($t3)
	
while:  slti $t0, $s0, 10
	beq $t0, $zero, fi
	
	addiu $t4, $s0, -1
	sll $t5, $t4, 2
	addu $t5, $t3, $t5
	lw $t5, 0($t5)
	addiu $t6, $s0, -2
	sll $t7, $t6, 2
	addu $t7, $t3, $t7
	lw $t7, 0($t7)
	sll $t8, $s0, 2
	addu $t8, $t3, $t8
	addu $t2, $t5, $t7
	sw $t2, 0($t8) 
	
	
	addiu $s0, $s0, 1
	b while

fi:

	jr $ra		# main retorna al codi de startup

