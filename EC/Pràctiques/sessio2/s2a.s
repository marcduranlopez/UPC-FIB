	.data

	.text
	.globl main
main:
	li $s1, 23 # Y
	li $s0, 8  # X

	li $s2, 1
	sllv $s3, $s2, $s0
	subu $s4, $s3, $s2
	xor $s5, $s4, $s1


	jr $ra
