cmake_minimum_required(VERSION 3.20)
project(C_DataStructure C)

set(CMAKE_C_STANDARD 11)

#[[
add_executable(C_DataStructure main.c Practice_Ch2/Ex1.c Practice_Ch2/Ex2.c Practice_Ch2/Ex3.c Practice_Ch2/Ex4.c Practice_Ch2/Ex5.c Practice_Ch2/Ex6.c Practice_Ch2/Ex7.c Practice_Ch2/Ex8.c Practice_Ch2/Ex9.c Practice_Ch2/Ex10.c)
]]

add_executable(Practice_Ch2_Ex1 Practice_Ch2/Ex1.c)
add_executable(Practice_Ch2_Ex2 Practice_Ch2/Ex2.c)
add_executable(Practice_Ch2_Ex3 Practice_Ch2/Ex3.c)
add_executable(Practice_Ch2_Ex4 Practice_Ch2/Ex4.c)
add_executable(Practice_Ch2_Ex5 Practice_Ch2/Ex5.c)
add_executable(Practice_Ch2_Ex6 Practice_Ch2/Ex6.c)
add_executable(Practice_Ch2_Ex8 Practice_Ch2/Ex8.c)
add_executable(Practice_Ch2_Ex7 Practice_Ch2/Ex7.c)
add_executable(main main.c)