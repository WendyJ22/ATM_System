# ATM System
The goal of human posture estimation is to infer the posture information of the human body in three-dimensional space based on image or video data, including bone structure, joint angle and body parts. 
Using an ML model to estimate the spatial locations of key body joints is the basis of many computer vision tasks, such as action classification, abnormal behaviour detection, and automatic driving.


## Installation instructions

1. Set up the new environment

    a. Create new environment and install main packages
    ```
      conda create -n pose
    ```
    b. Load environment
    ```
      conda activate pose
    ```
    c. Install additional packages
      ```
      pip install cv2
      pip install matplotlib
      pip install numpy
      ```

## Run instructions
- Open `test_infer.ipynb` and execute the code

## Training

### Network Architecture
![image_name](https://github.com/WendyJ22/Pose_Estimation/blob/main/readme/architecture.png)

### Training Steps 
- Two stages, each stage has two branches: the first branch outputs 18 feature maps, representing 18 human body key points and background respectively; the second branch has 38 feature maps, representing PAF (_Part Affinity Fields_), the connection between the joint and the previous joint.
- Use the previous 18 feature maps of the joints to extract the position and confidence .
- Traverse the feature map of each joint, extract key point information, and output all captured key points.
- Find key point indexes that can be paired and connected. 
- Mark different parts with different colors.


