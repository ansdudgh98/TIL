# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.20

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Volumes/data/study/C_DataStructure

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Volumes/data/study/C_DataStructure/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Practice_Ch2_Ex3.dir/depend.make
# Include the progress variables for this target.
include CMakeFiles/Practice_Ch2_Ex3.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Practice_Ch2_Ex3.dir/flags.make

CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.o: CMakeFiles/Practice_Ch2_Ex3.dir/flags.make
CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.o: ../Practice_Ch2/Ex3.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Volumes/data/study/C_DataStructure/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.o -c /Volumes/data/study/C_DataStructure/Practice_Ch2/Ex3.c

CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Volumes/data/study/C_DataStructure/Practice_Ch2/Ex3.c > CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.i

CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Volumes/data/study/C_DataStructure/Practice_Ch2/Ex3.c -o CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.s

# Object files for target Practice_Ch2_Ex3
Practice_Ch2_Ex3_OBJECTS = \
"CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.o"

# External object files for target Practice_Ch2_Ex3
Practice_Ch2_Ex3_EXTERNAL_OBJECTS =

Practice_Ch2_Ex3: CMakeFiles/Practice_Ch2_Ex3.dir/Practice_Ch2/Ex3.c.o
Practice_Ch2_Ex3: CMakeFiles/Practice_Ch2_Ex3.dir/build.make
Practice_Ch2_Ex3: CMakeFiles/Practice_Ch2_Ex3.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Volumes/data/study/C_DataStructure/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable Practice_Ch2_Ex3"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Practice_Ch2_Ex3.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Practice_Ch2_Ex3.dir/build: Practice_Ch2_Ex3
.PHONY : CMakeFiles/Practice_Ch2_Ex3.dir/build

CMakeFiles/Practice_Ch2_Ex3.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Practice_Ch2_Ex3.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Practice_Ch2_Ex3.dir/clean

CMakeFiles/Practice_Ch2_Ex3.dir/depend:
	cd /Volumes/data/study/C_DataStructure/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Volumes/data/study/C_DataStructure /Volumes/data/study/C_DataStructure /Volumes/data/study/C_DataStructure/cmake-build-debug /Volumes/data/study/C_DataStructure/cmake-build-debug /Volumes/data/study/C_DataStructure/cmake-build-debug/CMakeFiles/Practice_Ch2_Ex3.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Practice_Ch2_Ex3.dir/depend

