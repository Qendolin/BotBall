func collectFlufs() State {
	const 
	wb.Set_servo_position(0, 0)
	//drive along line
	shakeShovel := func() {
		startPos := wb.Get_servo_position(0)
		for i := 0; i < 8; i++ {
			if i % 2 == 0 {
				wb.Set_servo_position(0, startPos + 110)
				for wb.Get_servo_position(0) < startPos + 100 {
				}
			} else {
				wb.Set_servo_position(0, startPos - 10)
				for wb.Get_servo_position(0) > startPos {
				}
			}
		}
		wb.Set_servo_position(0, startPos)
	}
	for i := 0; i < 2; i++ {
		wb.Set_servo_position(0,0)
		wb.Msleep(250)
		drive.DriveRegulated(0.4, 10)
		wb.Msleep(250)
		wb.Set_servo_position(0, 1000)
		wb.Msleep(250)
		shakeShovel()
		wb.Msleep(250)
		drive.DriveRegulated(-0.4, -10)
		wb.Msleep(250)
	}

}