#include "mecanicalQuantitiesFunctions.h"

v calculateSpeed(s s1, s s2, t t1, t t2)
{
	return (double) ((s2 - s1) / (t2 -t1));
}

a calculateAcceleration(v v2, v v1, t t2, t t1)
{
	return (double) ((v2 -v1) / (t2 - t1));
}

p calculateMomentum(m m0, v v0)
{
	return (double) (m0 * v0);
}
