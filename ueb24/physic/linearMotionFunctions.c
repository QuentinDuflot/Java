#include "linearMotionFunctions.h"

s calculateDistanceUniformLinearMotion(v vt, t tt, t t0)
{
	return (double) (vt*(tt - t0));
}

s calculateDistanceNonUniformLinearMotion(v vt, v v0, a at)
{
	return (double) (vt*vt - v0*v0) / (2 * at);
}

v calculateSpeedNonUniformLinearMotion(a at, t tt, t t0, v v0)
{
	return (double)(at * (tt - t0) + v0);
}
