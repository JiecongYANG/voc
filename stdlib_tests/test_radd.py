import cmath
x1=4
x2=4.4
x3=False
x4=complex(-1,5)

# test different types of value plus itself(int)
print(x1.__radd__(x1))
print(x1.__radd__(x2))
print(x1.__radd__(x3))
print(x1.__radd__(x4))
# test different types of value plus itself(float)
print(x2.__radd__(x1))
print(x2.__radd__(x2))
print(x2.__radd__(x3))
print(x2.__radd__(x4))
# test different types of value plus itself(bool)
print(x3.__radd__(x1))
print(x3.__radd__(x2))
print(x3.__radd__(x3))
print(x3.__radd__(x4))
# test different types of value plus itself(complex)
print(x4.__radd__(x1))
print(x4.__radd__(x2))
print(x4.__radd__(x3))
print(x4.__radd__(x4))


