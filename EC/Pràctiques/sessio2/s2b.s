	.data
result: .word 0
num:    .byte '7'

	.text
	.globl main
main:	
	li $t0, 0x61
	la $s0, num
	lb $s1, 0($s0)
	blt $s1, $t0, or1
	li $t1, 0x7A
	ble $s1, $t1, result1
or1:	
	li $t2, 0x41
	blt $s1, $t2, else1
	li $t3, 0x5A
	bgt $s1, $t3, else1
result1:
	move $v1, $s1
else1:
	li $t4, 0x30
	blt $s1, $t4, else2
	li $t5, 0x39
	bgt $s1, $t5, else2
	subu $v1, $s1, $t4
	b end1
else2:
	li $v1, -1
end1:
	jr $ra